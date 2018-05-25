package hu.balpo.rategp.event;

public class LoginEvent {
    private boolean success;

    public LoginEvent(){}

    public LoginEvent(boolean success){
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
