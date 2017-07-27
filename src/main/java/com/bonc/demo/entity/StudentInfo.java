/*
 * 文件名：StudentInfo.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月21日
 */

package com.bonc.demo.entity;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

/*@Table(name="student")
@Entity*/
public class StudentInfo
{
//    @Id
    int id;
    String name;
    String sex;
    Date birth;
    String department;
    String address;
    public StudentInfo() {
    }
    
    
    public StudentInfo(int id, String name, String sex, Date birth, String department,
                       String address)
    {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.department = department;
        this.address = address;
    }


    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public Date getBirth()
    {
        return birth;
    }
    public void setBirth(Date birth)
    {
        this.birth = birth;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    
}
