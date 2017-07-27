/*
 * 文件名：Student.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月21日
 */

package com.bonc.demo.entity;

public class Student
{
    private String sno; //学号
    private String name; //姓名
    private String age; //年龄
    private float score; //成绩
    public Student()
    {
        super();
    }
    public Student(String sno, String name, String age, float score)
    {
        
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public String getSno()
    {
        return sno;
    }
    public void setSno(String sno)
    {
        this.sno = sno;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public float getScore()
    {
        return score;
    }
    public void setScore(float score)
    {
        this.score = score;
    }
}
