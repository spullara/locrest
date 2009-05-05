package com.sampullara.locrest;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Result {
  @XmlElement
  public String country;
  @XmlElement
  public String region;
  @XmlElement
  public String city;
  @XmlElement
  public String zipcode;
  @XmlElement
  public Double latitude;
  @XmlElement
  public Double longitude;
}
