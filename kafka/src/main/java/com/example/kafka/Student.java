package com.example.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	@JsonProperty(value="stdid")
    private String stdid;
	
    @JsonProperty(value="stdname")
    private String stdname;
    
    @JsonProperty(value="stdlastname")
    private String stdlastname;
    
    @JsonProperty(value="stdadd")
    private String stdadd;
    
    @JsonProperty(value="stdcity")
    private String stdcity;
    
    @JsonProperty(value="stdstate")
    private String stdstate;
    
    @JsonProperty(value="stdzip")
    private String stdzip;
    
    @JsonProperty(value="stddate")
    private String stddate;
    
    @JsonProperty(value="stdtel")
    private String stdtel;
    
    @JsonProperty(value="stdemail")
    private String stdemail;
    
    @JsonProperty(value="stdurl")
    private String stdurl;
    
    @JsonProperty(value="stdmonth")
    private String stdmonth;
    
    @JsonProperty(value="stdyear")
    private String stdyear;
    
    @JsonProperty(value="stdcheckbox")
    private String stdcheckbox;
    
    public String getStdlastname() {
		return stdlastname;
	}

	public void setStdlastname(String stdlastname) {
		this.stdlastname = stdlastname;
	}

	private String stdradio;
    private String stdlike;
    private String stddata;
    
    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }
    
    public String getStdcity() {
        return stdcity;
    }

    public void setStdcity(String stdcity) {
        this.stdcity = stdcity;
    }
    public String getStdstate() {
        return stdstate;
    }

    public void setStdstate(String stdstate) {
        this.stdstate = stdstate;
    }
    public String getStdadd() {
        return stdadd;
    }

    public void setStdadd(String stdadd) {
        this.stdadd = stdadd;
    }
    public String getStdzip() {
        return stdzip;
    }

    public void setStdzip(String stdzip) {
        this.stdzip = stdzip;
    }
    public String getStdtel() {
        return stdtel;
    }

    public void setStdtel(String stdtel) {
        this.stdtel = stdtel;
    }
    public String getStddate() {
        return stddate;
    }

    public void setStddate(String stddate) {
        this.stddate = stddate;
    }
    public String getStdemail() {
        return stdemail;
    }

    public void setStdemail(String stdemail) {
        this.stdemail = stdemail;
    }
    public String getStdurl() {
        return stdurl;
    }

    public void setStdurl(String stdurl) {
        this.stdurl = stdurl;
    }
    public String getStdmonth() {
        return stdmonth;
    }
    

   

	public String getStdcheckbox() {
		return stdcheckbox;
	}

	public void setStdcheckbox(String stdcheckbox) {
		this.stdcheckbox = stdcheckbox;
	}

	public void setStdmonth(String stdmonth) {
        this.stdmonth = stdmonth;
    }
    public String getStdyear() {
        return stdyear;
    }

    public void setStdyear(String stdyear) {
        this.stdyear = stdyear;
    }
    
    public String getStdradio() {
        return stdradio;
    }

    public void setStdradio(String stdradio) {
        this.stdradio = stdradio;
    }
    
    public String getStdlike() {
        return stdlike;
    }

    public void setStdlike(String stdlike) {
        this.stdlike = stdlike;
    }
 
    
    public String getStddata() {
        return stddata;
    }

    public void setStddata(String stddata) {
        this.stddata = stddata;
    }

}
