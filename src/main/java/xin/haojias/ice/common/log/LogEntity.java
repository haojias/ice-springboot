package xin.haojias.ice.common.log;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

@Entity
@Table(name = "ice_log")
public class LogEntity implements Serializable {

    //编号
    @Id
    @GeneratedValue
    @Column(name = "ice_id")
    private Long id;
    //客户端请求ip
    @Column(name = "ice_client_ip")
    private String clientIp;
    //客户端请求路径
    @Column(name = "ice_uri")
    private String uri;
    //终端请求方式,普通请求,ajax请求
    @Column(name = "ice_type")
    private String type;
    //请求方式method,post,get等
    @Column(name = "ice_method")
    private String method;
    //请求参数内容,json
    @Column(name = "ice_param_data")
    private String paramData;
    //请求接口唯一session标识
    @Column(name = "ice_session_id")
    private String sessionId;
    //请求时间
    @Column(name = "ice_time",insertable = false)
    private Long time;
    //接口返回时间
    @Column(name = "ice_returm_time")
    private Long returnTime;
    //接口返回数据json
    @Column(name = "ice_return_data")
    private String returnData;
    //请求时httpStatusCode代码，如：200,400,404等
    @Column(name = "ice_http_status_code")
    private String httpStatusCode;
    //请求耗时秒单位
    @Column(name = "ice_time_consuming")
    private int timeConsuming;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Long returnTime) {
        this.returnTime = returnTime;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }


    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
