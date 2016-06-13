package test.com.qiandaibaobao.auth;

/**
 * Created by Administrator on 2016/5/31 0031.
 */
public class Emp {
    private int empId;
    private String empName;
    private String empNo;
    private String organId;
    private String password;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String sep = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append("empId:%s");
        sb.append(sep);
        sb.append("empName:%s");
        sb.append(sep);
        sb.append("empOrganId:%s");
        sb.append(sep);
        sb.append("empNo:%s");
        sb.append(sep);
        sb.append("empPasswd:%s");
        return String.format(sb.toString(), String.valueOf(empId), empName, organId, empNo, password);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null){
           return false;
        }
        if(!(obj instanceof Emp)){
            return false;
        }
        Emp newEmp = (Emp)obj;
        if(newEmp.getEmpId()==this.empId){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return empId;
    }
}
