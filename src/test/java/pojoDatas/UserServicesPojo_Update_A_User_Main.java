package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
{
    "id": 1849,
    "username": "putdeneme@cisco.com",
    "email": "putdeneme@cisco.com",
    "is_email_verified": false,
    "status_id": 1,
    "status": {
        "id": 1,
        "name": "Active",
        "description": "User account is activated and authorized to use the application"
    },
    "organization_id": 1715290785259464,
    "app_id": 2,
    "membership_type_id": 5,
    "default_role_id": 30,
    "subscription_id": "3d2fbde1-d022-4107-9321-413380705457",
    "is_individual_membership": false,
    "password": "0XTCtTL9jS0CNqb",
    "is_owner": false,
    "is_active": true,
    "is_default": true,
    "membership_created_at": "2024-05-13T06:18:23.869044Z",
    "membership_updated_at": "2024-05-13T06:18:23.869045Z"
}

*/
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserServicesPojo_Update_A_User_Main {

private String id;
private String username;
private String email;
private String is_email_verified;
private String status_id;

private UserServicesPojo_Update_A_User_Status updateAUserStatus;
private String organization_id;
private String app_id;
private String membership_type_id;
private String default_role_id;
private String subscription_id;
private String is_individual_membership;
private String password;
private String is_owner;
private String is_active;
private String is_default;
private String created_at;
private String membership_updated_at;


    public UserServicesPojo_Update_A_User_Main() {
    }

    public UserServicesPojo_Update_A_User_Main(String id, String username, String email, String is_email_verified, String status_id, UserServicesPojo_Update_A_User_Status updateAUserStatus, String organization_id, String app_id, String membership_type_id, String default_role_id, String subscription_id, String is_individual_membership, String password, String is_owner, String is_active, String is_default, String created_at, String membership_updated_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.is_email_verified = is_email_verified;
        this.status_id = status_id;
        this.updateAUserStatus = updateAUserStatus;
        this.organization_id = organization_id;
        this.app_id = app_id;
        this.membership_type_id = membership_type_id;
        this.default_role_id = default_role_id;
        this.subscription_id = subscription_id;
        this.is_individual_membership = is_individual_membership;
        this.password = password;
        this.is_owner = is_owner;
        this.is_active = is_active;
        this.is_default = is_default;
        this.created_at = created_at;
        this.membership_updated_at = membership_updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_email_verified() {
        return is_email_verified;
    }

    public void setIs_email_verified(String is_email_verified) {
        this.is_email_verified = is_email_verified;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public UserServicesPojo_Update_A_User_Status getUpdateAUserStatus() {
        return updateAUserStatus;
    }

    public void setUpdateAUserStatus(UserServicesPojo_Update_A_User_Status updateAUserStatus) {
        this.updateAUserStatus = updateAUserStatus;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMembership_type_id() {
        return membership_type_id;
    }

    public void setMembership_type_id(String membership_type_id) {
        this.membership_type_id = membership_type_id;
    }

    public String getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(String default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getIs_individual_membership() {
        return is_individual_membership;
    }

    public void setIs_individual_membership(String is_individual_membership) {
        this.is_individual_membership = is_individual_membership;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_owner() {
        return is_owner;
    }

    public void setIs_owner(String is_owner) {
        this.is_owner = is_owner;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String membership_created_at) {
        this.created_at = membership_created_at;
    }

    public String getMembership_updated_at() {
        return membership_updated_at;
    }

    public void setMembership_updated_at(String membership_updated_at) {
        this.membership_updated_at = membership_updated_at;
    }

    @Override
    public String toString() {
        return "UserServicesPojo_Update_A_User_Main{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", is_email_verified='" + is_email_verified + '\'' +
                ", status_id='" + status_id + '\'' +
                ", updateAUserStatus=" + updateAUserStatus +
                ", organization_id='" + organization_id + '\'' +
                ", app_id='" + app_id + '\'' +
                ", membership_type_id='" + membership_type_id + '\'' +
                ", default_role_id='" + default_role_id + '\'' +
                ", subscription_id='" + subscription_id + '\'' +
                ", is_individual_membership='" + is_individual_membership + '\'' +
                ", password='" + password + '\'' +
                ", is_owner='" + is_owner + '\'' +
                ", is_active='" + is_active + '\'' +
                ", is_default='" + is_default + '\'' +
                ", membership_created_at='" + created_at + '\'' +
                ", membership_updated_at='" + membership_updated_at + '\'' +
                '}';
    }
}
