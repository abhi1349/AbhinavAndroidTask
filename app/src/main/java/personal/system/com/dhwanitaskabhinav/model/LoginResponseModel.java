package personal.system.com.dhwanitaskabhinav.model;

public class LoginResponseModel extends BaseApiResponseModel {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
