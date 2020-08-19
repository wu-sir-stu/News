package edu.hbuas.entity;


import java.io.Serializable;

public class Topic implements Serializable {

  private int tid;
  private String tname;


  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }

  public Topic() {
  }

  public Topic(int tid, String tname) {
    this.tid = tid;
    this.tname = tname;
  }

  @Override
  public String toString() {
    return "Topic{" +
            "tid=" + tid +
            ", tname='" + tname + '\'' +
            '}';
  }
}
