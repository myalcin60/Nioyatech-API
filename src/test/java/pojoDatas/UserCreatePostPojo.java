package pojoDatas;

public class UserCreatePostPojo {

    private String app_id;
    private String organization_id;
    private String email;
    private String subscription_id;
    private String default_role_id;

    public UserCreatePostPojo() {
    }

    public UserCreatePostPojo(String app_id, String organization_id, String email, String subscription_id, String default_role_id) {
        this.app_id = app_id;
        this.organization_id = organization_id;
        this.email = email;
        this.subscription_id = subscription_id;
        this.default_role_id = default_role_id;
    }


    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(String default_role_id) {
        this.default_role_id = default_role_id;
    }

    @Override
    public String toString() {
        return "UserCreatePostPojo{" +
                "app_id='" + app_id + '\'' +
                ", organization_id='" + organization_id + '\'' +
                ", email='" + email + '\'' +
                ", subscription_id='" + subscription_id + '\'' +
                ", default_role_id='" + default_role_id + '\'' +
                '}';
    }
}
