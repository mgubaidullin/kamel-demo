import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class Sample extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:tick")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Hello World !");
                    }
                })
                .setBody(constant("- Hello Kamel"))
                .to("log:info?skipBodyLineSeparator=false");
    }
}
