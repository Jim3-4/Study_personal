package di;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//XML 파일을 대신할 JAVA 설정 파일(DI)
//@Configuration, @Bean 어노테이션을 사용해야 된다.
@Configuration
public class Config {
   //RecordImpl record = new RecordImpl();
   //<bean id="record" class="di.RecordImpl"></bean>
   @Bean
   public RecordImpl record() {
      return new RecordImpl();
   }
   
   
   /*
    * <bean id="rvi" class="di.RecordViewImpl"> <property name="record"
    * ref="record"></property> </bean>
    * 
    */
   
   @Bean(name="rvi")
   public RecordViewImpl getRecordViewImpl() {
      RecordViewImpl rvi = new RecordViewImpl();
      rvi.setRecord(record());//setter 프로퍼티를 통해서 DI
      return rvi;
   }
   
}