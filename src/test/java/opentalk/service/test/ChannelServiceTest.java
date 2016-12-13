package opentalk.service.test;

import opentalk.dao.ChannelMemberRepository;
import opentalk.dao.ChannelRepository;
import opentalk.domainmodel.Channel;
import opentalk.domainmodel.ChannelMember;
import opentalk.domainmodel.ChannelStatus;
import opentalk.service.ChannelService;
import opentalk.service.ChannelServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Ivan Chan on 11/9/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class ChannelServiceTest {
    @Mock
    private ChannelRepository mockChannelRepository;
    @Mock
    private ChannelMemberRepository mockChannelMemberRepository;

    @InjectMocks
    private ChannelService channelService = new ChannelServiceImpl();

    @Test
    public void createNewChannel_NewChannelInfo_ShouldReturnNewChannel() {
        UUID channelKey = UUID.randomUUID();
        String channelName = "TEST Channel";
        Channel channelToAdd = new Channel();
        channelToAdd.setChannelKey(channelKey);
        channelToAdd.setChannelName(channelName);
        channelToAdd.setPublicChannel(false);
        when(mockChannelRepository.save(channelToAdd)).thenReturn(channelToAdd);
        Channel newChannel = channelService.addChannel(channelToAdd);

        assertNotNull(newChannel);
        assertEquals("Channel key should be matched.", newChannel.getChannelKey(), channelToAdd.getChannelKey());
        assertEquals("Channel name should be matched.", newChannel.getChannelName(), channelToAdd.getChannelName());
        assertEquals("Public channel flag should be matched.", newChannel.isPublicChannel(), channelToAdd.isPublicChannel());
    }

    @Test
    public void createNewChannel_NewChannelInfoWithEmptyKey_ShouldReturnNewChannelWithGeneratedKey() {
        UUID channelKey = null;
        String channelName = "TEST Channel";
        Channel channelToAdd = new Channel();
        channelToAdd.setChannelKey(channelKey);
        channelToAdd.setChannelName(channelName);
        channelToAdd.setPublicChannel(false);
        when(mockChannelRepository.save(channelToAdd)).thenReturn(channelToAdd);
        Channel newChannel = channelService.addChannel(channelToAdd);

        assertNotNull("Channel Key should not be null.", newChannel.getChannelKey());
        assertNotEquals("Channel key should not be empty", new UUID(0, 0), newChannel.getChannelKey());
    }

    @Test
    public void getChannelInfo_ExistChannelKey_ShouldReturnExistChannelInfo() {
        UUID channelKey = UUID.fromString("78258531-4df0-47bd-b3fc-37c562b17628");
        Channel channelTest = new Channel();
        channelTest.setChannelKey(channelKey);
        channelTest.setChannelName("Unit Test Channel");
        when(mockChannelRepository.findOne(channelKey)).thenReturn(channelTest);
        Channel channelExist = channelService.getChannel(channelKey);
        assertNotNull("Returned channel should not be null", channelExist);
        assertEquals("Channel key should be matched", channelTest.getChannelKey(), channelExist.getChannelKey());
        assertEquals("Channel name should be matched", channelTest.getChannelName(), channelTest.getChannelName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getChannelInfo_NullChannelKey_ShouldCauseException() {
        UUID channelKey;

        channelKey = null;
        when(mockChannelRepository.findOne(channelKey)).thenReturn(null);
        Channel channelExist = channelService.getChannel(channelKey);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getChannelInfo_EmptyChannelKey_ShouldCauseException() {
        UUID channelKey;

        channelKey = new UUID(0, 0);
        when(mockChannelRepository.findOne(channelKey)).thenReturn(null);
        Channel channelExist = channelService.getChannel(channelKey);
    }

    @Test
    public void listChannel_ShouldReturnAllExistsChannel() {
        Channel channelTestA = new Channel(UUID.fromString("5165a37e-9b34-4510-af92-2479202913e5"), "Channel Test A", "Channel Desc A", true, ChannelStatus.Active);
        Channel channelTestB = new Channel(UUID.fromString("bb80e8fd-7368-437c-8b22-428dafb5909c"), "Channel Test B", "Channel Desc B", true, ChannelStatus.Active);
        Channel channelTestC = new Channel(UUID.fromString("e86712ee-b32e-4f47-aa2c-059bbe7a0881"), "Channel Test C", "Channel Desc C", true, ChannelStatus.Active);
        List<Channel> listChannelTest = new ArrayList<Channel>();
        listChannelTest.add(channelTestA);
        listChannelTest.add(channelTestB);
        listChannelTest.add(channelTestC);
        when(mockChannelRepository.findAll()).thenReturn(listChannelTest);
        List<Channel> listChannelExist = channelService.listChannels();
        assertNotNull("Returned channel list should not be null", listChannelExist);
        assertArrayEquals("Returned channel list should be matched", listChannelTest.toArray(), listChannelExist.toArray());
    }

    @Test(expected=IllegalArgumentException.class)
    public void deleteChannel_NotExistChannelKey_ShouldCauseException() {
        UUID channelKey = UUID.randomUUID();
        when(mockChannelRepository.findOne(channelKey)).thenReturn(null);
        Mockito.doNothing().when(mockChannelRepository).delete(channelKey);
        channelService.deleteChannel(channelKey);
    }

    @Test
    public void deleteChannel_ExistChannelKey_WithoutException() {
        UUID channelKey = UUID.randomUUID();
        Channel channelToBeDelete = new Channel(channelKey, "Channel to be deleted", "", true, ChannelStatus.Active);
        when(mockChannelRepository.findOne(channelKey)).thenReturn(channelToBeDelete);
        Mockito.doNothing().when(mockChannelRepository).delete(channelKey);

        Exception ex = null;
        try {
            channelService.deleteChannel(channelKey);
        }catch(Exception e) {
            ex = e;
        }
        assertNull("Should not throw any exception", ex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateChannel_NotExistChannel_ShouldCauseException() {
        UUID channelKey = UUID.randomUUID(); //Not exist key
        Channel channelToUpdate = new Channel(channelKey, "Channel to be updated", "", true, ChannelStatus.Active);
        when(mockChannelRepository.findOne(channelKey)).thenReturn(null);
        channelService.updateChannel(channelToUpdate);
    }

    @Test
    public void updateChannel_ExistChannel_ReturnUpdatedChannel() {
        UUID channelKey = UUID.randomUUID(); //Exist key
        Channel channelExist = new Channel(channelKey, "Existing Channel", "", true, ChannelStatus.Active);
        when(mockChannelRepository.findOne(channelKey)).thenReturn(channelExist);
        when(mockChannelRepository.save(channelExist)).thenReturn(channelExist);
        channelExist.setChannelName("Updated Channel");
        Channel channelUpdated = channelService.updateChannel(channelExist);
        assertNotNull("Updated channel should not be null", channelUpdated);
        assertEquals("Updated Channel name should be matched", channelExist.getChannelName(), channelUpdated.getChannelName());
    }

    @Test
    public void addChannelMember_ChannelMember_ReturnAddedChannelMember() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.save(member)).thenReturn(member);
        channelService.setChannelKey(channelKey);
        ChannelMember savedMember = channelService.addChannelMember(member);
        assertNotNull("Saved member should not be null", savedMember);
        assertEquals("Saved member key should be matched", memberKey.toString(), savedMember.getChannelMemberKey().toString());
        assertEquals("Saved channel key should be matched", channelKey.toString(), savedMember.getChannelKey().toString());
        assertEquals("Saved user key should be matched", userKey.toString(), savedMember.getUserKey().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addChannelMember_WithoutChannelKey_CauseException() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.save(member)).thenReturn(member);
        channelService.setChannelKey(null);
        ChannelMember savedMember = channelService.addChannelMember(member);
    }

    @Test
    public void addChannelMember_MemberWithEmptyChannelKey_ReturnMemberWithChannelKey() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.save(member)).thenReturn(member);
        channelService.setChannelKey(channelKey);
        member.setChannelKey(null);
        ChannelMember savedMember = channelService.addChannelMember(member);
        assertNotNull("Returned member should not be null", savedMember);
        assertEquals("Member channel key should match with service channel key", savedMember.getChannelKey().toString(), channelKey.toString());
    }

    @Test
    public void addChannelMember_MemberWithEmptyMemberKey_ReturnMemberWithMemberKey() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.save(member)).thenReturn(member);
        channelService.setChannelKey(channelKey);
        member.setChannelMemberKey(null);
        ChannelMember savedMember = channelService.addChannelMember(member);
        member.setChannelMemberKey(new UUID(0, 0));
        ChannelMember savedMemberA = channelService.addChannelMember(member);
        assertNotNull("Returned member should not be null", savedMember);
        assertNotNull("Channel Member key should be auto-generated.", savedMember.getChannelMemberKey());
        assertNotNull("Returned member should not be null", savedMemberA);
        assertNotNull("Channel Member key should be auto-generated.", savedMemberA.getChannelMemberKey());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeChannelMember_WithoutChannelKey_CauseException() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        channelService.setChannelKey(null);
        Mockito.doNothing().when(mockChannelMemberRepository).delete(memberKey);
        channelService.removeChannelMember(memberKey);
    }

    @Test
    public void removeChannelMember_WithChannelKey_ReturnNothing() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        channelService.setChannelKey(channelKey);
        Mockito.doNothing().when(mockChannelMemberRepository).delete(memberKey);
        Exception ex = null;
        try {
            channelService.removeChannelMember(memberKey);
        }catch(Exception e) {
            ex = e;
        }
        assertNull("Should not throw any exception", ex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getChannelMember_WithoutChannelKey_CauseException() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.findOne(memberKey)).thenReturn(member);
        channelService.setChannelKey(null);
        ChannelMember existMember = channelService.getChannelMember(memberKey);
    }

    @Test
    public void getChannelMember_WithChannelKey_ReturnChannelMember() {
        UUID channelKey = UUID.randomUUID();
        UUID memberKey = UUID.randomUUID();
        UUID userKey = UUID.randomUUID();
        ChannelMember member = new ChannelMember(memberKey, userKey, channelKey);
        when(mockChannelMemberRepository.findOne(memberKey)).thenReturn(member);
        channelService.setChannelKey(channelKey);
        ChannelMember existMember = channelService.getChannelMember(memberKey);
        assertNotNull("Returned channel member should not be null", existMember);
        assertEquals("Member key should be matached", member.getChannelMemberKey().toString(), existMember.getChannelMemberKey().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void listChannelMembers_WithoutChannelKey_CauseException() {
        ChannelMember memberA = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        ChannelMember memberB = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        ChannelMember memberC = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        List<ChannelMember> listChannelMembers = new ArrayList<ChannelMember>();
        listChannelMembers.add(memberA);
        listChannelMembers.add(memberB);
        listChannelMembers.add(memberC);
        when(mockChannelMemberRepository.findAll()).thenReturn(listChannelMembers);
        channelService.setChannelKey(null);
        List<ChannelMember> listExistChannelMembers = channelService.listChannelMembers();
    }

    @Test
    public void listChannelMembers_WithChannelKey_ReturnChannelMemberList() {
        UUID channelKey = UUID.randomUUID();
        ChannelMember memberA = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), channelKey);
        ChannelMember memberB = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), channelKey);
        ChannelMember memberC = new ChannelMember(UUID.randomUUID(), UUID.randomUUID(), channelKey);
        List<ChannelMember> listChannelMembers = new ArrayList<ChannelMember>();
        listChannelMembers.add(memberA);
        listChannelMembers.add(memberB);
        listChannelMembers.add(memberC);
        //when(mockChannelMemberRepository.listMembers(channelKey)).thenReturn(listChannelMembers);
        channelService.setChannelKey(channelKey);
        List<ChannelMember> listExistChannelMembers = channelService.listChannelMembers();
        assertNotNull("Returned channel member list should not be null", listExistChannelMembers);
        assertArrayEquals("Returned channel member list should be matched", listChannelMembers.toArray(), listExistChannelMembers.toArray());
    }

    @Test
    public void constructor_WithChannelKey_getSameChannelKey() {
        UUID channelKey = UUID.randomUUID();
        ChannelService service = new ChannelServiceImpl(channelKey);
        UUID savedChannelKey = service.getChannelKey();
        assertEquals("Channel Key should be matched", channelKey.toString(), savedChannelKey.toString());
    }
}