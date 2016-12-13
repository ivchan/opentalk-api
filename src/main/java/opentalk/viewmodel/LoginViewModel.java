package opentalk.viewmodel;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivanchan on 21/11/2016.
 */
public class LoginViewModel {
    @NotEmpty
    @Length(max = 100)
    private String loginName;
    private String loginPassword;

    public LoginViewModel() {
        this.loginName = "";
        this.loginPassword = "";
    }

    public LoginViewModel(String loginName, String loginPassword) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
