package tn.mine.banque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import tn.mine.banque.rmi.IBanqueRmiRemote;



@Configuration
public class myConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJaxWs() {
		
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8003/Banque");
		return exporter;
		
	}
	
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext context) {
		
		RmiServiceExporter exporter = new RmiServiceExporter();
		
		
		exporter.setService(context.getBean("myRmiService"));
		exporter.setRegistryPort(8004);
		exporter.setServiceInterface(IBanqueRmiRemote.class);
		exporter.setServiceName("BanqueService");//RmiExporter va pubier la reference de l'obj RMI  dans l'annuaire "JNDI" sous le "BanqueService"
		return exporter;
		
	}
	
	
}
