package test.com.qiandaibaobao.auth;

import com.qiandaibaobao.auth.Emp;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * JedisTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class JedisTest {
    private final JedisPool jedisPool;
    public JedisTest(){
        jedisPool = new JedisPool("121.42.149.46", 6379);
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testPutAndGet() throws Exception{
        Emp emp = new Emp();
        emp.setEmpId(1);
        emp.setEmpNo("001");
        emp.setEmpName("张三");
        emp.setPassword("zhangsan123");
        emp.setOrganId("101");

        System.out.println("emp = " + emp);

        String result = putEmp(emp);
        Assert.assertEquals(result, "OK");
        Emp getEmp = getEmp(emp.getEmpId());
//        Assert.assertSame(getEmp, emp);
        Assert.assertEquals(getEmp.getEmpId(), emp.getEmpId());

    }

    /**
     * 将emp存入redis
     * @param emp
     * @return
     * @throws Exception
     */
    private String putEmp(Emp emp) throws Exception{
        Jedis jedis = jedisPool.getResource();
        jedis.auth("redis");
        try {
            String key = "emp" + emp.getEmpId();
            byte[] bytes = ProtobufIOUtil.toByteArray(emp, schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            int timeout = 60 * 60;//1小时
            String result = jedis.setex(key.getBytes(), timeout, bytes);

            return result;
        }finally {
            jedis.close();
        }

    }

    /**
     * 根据empId从redis中取emp
     * @param empId
     * @return
     * @throws Exception
     */
    private Emp getEmp(int empId)throws Exception{
        String key = "emp" + empId;
        Jedis jedis = jedisPool.getResource();
        jedis.auth("redis");
        try  {
            byte[] bytes = jedis.get(key.getBytes());
            if (bytes != null) {
                Emp emp = schema.newMessage();
                ProtobufIOUtil.mergeFrom(bytes, emp, schema);
                return emp;
            }
        }finally {
            jedis.close();
        }
        return null;
    }
    private RuntimeSchema<Emp> schema = RuntimeSchema.createFrom(Emp.class);

} 
