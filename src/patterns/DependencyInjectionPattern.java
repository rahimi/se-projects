package patterns;

import java.util.List;

public class DependencyInjectionPattern {
    interface Service{
        public void useService();
    }
    class ConstructorUsage{
        Service serviceDependency;
        public ConstructorUsage(Service service){
            serviceDependency = service;
        }
        public void useServiceDependency(){
            serviceDependency.useService();
        }
    }

    class SetterUsage{
        Service serviceDependency;
        public void setService(Service service){
            serviceDependency = service;
        }
        public void useServiceDependency(){
            serviceDependency.useService();
        }
    }

    interface ServiceConsumer{
        public void inject(Service s);
    }

    class InterfaceUsage implements ServiceConsumer{
        private Service service;

        @Override
        public void inject(Service s) {
            service = s;
        }

        public void useServiceDependency(){
            service.useService();
        }
    }
    class ServiceInjector{
        List<ServiceConsumer> consumers;
        public void register(ServiceConsumer c){
            c.inject(new Service() {
                @Override
                public void useService() {
                    System.out.println("Dummy Service Implementation!");
                }
            });
        }
        public void switchServiceTo(Service s){
            consumers.forEach((c)->c.inject(s));
        }
    }
}
