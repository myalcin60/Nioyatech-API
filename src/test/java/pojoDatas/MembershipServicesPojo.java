package pojoDatas;



    public class MembershipServicesPojo {
        private String detail;
        private String error;
        private String message;
        private Integer status;
        private String timestamp;

        public MembershipServicesPojo() {

        }
        public MembershipServicesPojo(String detail, String error, String message,Integer status,String timestamp) {
            this.detail = detail;
            this.error= error;
            this.message = message;
            this.status = status;
            this.timestamp =timestamp;
        }



        public void setDetail(String detail){
            this.detail = detail;
        }

        public String getDetail(){
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


        public String get(String error) { return error;

        }

        @Override
        public String toString(){
            return
                    "Response{" +
                            "detail = '" + detail + '\'' +
                            ",error = '" + error + '\'' +
                            ",message = '" + message + '\'' +
                            ",status = '" + status + '\'' +
                            ",timestamp = '" + timestamp + '\'' +
                            "}";
        }

    }


