package patterns;

public class StatePattern {
    public static void main(String[] args) {
        CleaningBot bot = new CleaningBot();
        bot.doWork();
        bot.next();
        bot.doWork();
        bot.next();
        bot.doWork();
        bot.next();
        bot.doWork();
    }
    static class CleaningBot{ //Context
        private CleaningStrategy current = new StartBot();
        void setStrategy(CleaningStrategy nextStrategy){
            current = nextStrategy;
        }
        void doWork(){
            current.doWork(this);
        }
    
        void next(){
            current.next(this);
        }
    }
    
    interface CleaningStrategy{ //State
        enum Type{standard, vacuum, mop};
        void doWork(CleaningBot bot);
        void next(CleaningBot bot);
    }
    
    static class StartBot implements CleaningStrategy { //Standard
        CleaningStrategy.Type current = CleaningStrategy.Type.standard;
        public void doWork(CleaningBot bot){
            System.out.println("Started Cleaning Bot");    
        }
        
        public void next(CleaningBot bot) {
            bot.setStrategy(new VacuumBot());
        }
    }

    static class VacuumBot implements CleaningStrategy {
        CleaningStrategy.Type current = CleaningStrategy.Type.vacuum;
        public void doWork(CleaningBot bot) {
            System.out.println("Vacuuming!");
        }
        public void next(CleaningBot bot) {
            bot.setStrategy(new MopBot());
        }
    }

    static class MopBot implements CleaningStrategy {
        CleaningStrategy.Type current = CleaningStrategy.Type.mop;
        public void doWork(CleaningBot bot) {
            System.out.println("Mopping!");
        }
        public void next(CleaningBot bot) {
            bot.setStrategy(new StartBot());
        }
    }
}

