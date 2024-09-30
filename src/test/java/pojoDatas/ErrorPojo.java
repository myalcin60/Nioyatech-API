package pojoDatas;

public class ErrorPojo{
	private Object detail;
	private String error;
	private String message;
	private Integer status;
	private String timestamp;

	public void setDetail(Object detail){
		this.detail = detail;
	}

	public Object getDetail(){
		return detail;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return status;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"ErrorPojo{" + 
			"detail = '" + detail + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}
