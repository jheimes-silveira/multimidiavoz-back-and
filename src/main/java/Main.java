import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.app.iqoption.model.Contato;


public class Main {

	public static void main(String[] args) {
		Contato c = new Contato();
		c.setId(1L);
		c.setNome("primeiro nome");
		c.setNumero("47439t49t");
		c.setContatos(new ArrayList<>());
		for(int i = 0 ; i < 10 ; i++) {
			c.getContatos().add(new Contato("dfbf "+ i, "db5546" + i));
		}
		ObjectMapper m = new ObjectMapper();

		Map<String,String> props = m.convertValue(c, Map.class);

		for(Map.Entry<String, String> entry : props.entrySet()){
		    if(entry.getValue() instanceof String || entry.getValue() instanceof String){
		        System.out.println(entry.getKey() + "-->" + entry.getValue());
		    }
		}
	}
	
	public static Map<String, String> objectToMap(Object obj, Class clazz) {
	    return Arrays.stream(clazz.getDeclaredMethods())
	            .filter(p -> !p.getName().startsWith("set"))
	            .filter(p -> !p.getName().startsWith("getClass"))
	            .filter(p -> !p.getName().startsWith("setClass"))
	            .collect(Collectors.toMap(
	                    d -> d.getName().substring(3),
	                    m -> {
	                        try {
	                            Object result = m.invoke(obj);
	                            return result.toString();
	                        } catch (Exception e) {
	                            return "";
	                        }
	                    }, (p1, p2) -> p1)
	            );
	}
}
