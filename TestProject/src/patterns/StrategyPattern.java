package patterns;

import patterns.StrategyPattern.CleaningStrategy.Type;

public class StrategyPattern {
    public static void main(String[] args) {
        CleaningBot bot = new CleaningBot();
        bot.setStrategy(CleaningStrategy.Type.standard);
        bot.doWork();
        bot.setStrategy(CleaningStrategy.Type.vacuum);
        bot.doWork();
        bot.setStrategy(CleaningStrategy.Type.mop);
        bot.doWork();
    }
    static class CleaningBot{ //Context
        private CleaningStrategy current = new StartBot();
        void setStrategy(CleaningStrategy.Type nextStrategy){
            if(nextStrategy == Type.standard){
                current = new StartBot();
            }else if(nextStrategy == Type.vacuum){
                current = new VacuumBot();
            }else if(nextStrategy == Type.mop){
                current = new MopBot();
            }
        }
        void doWork(){
            current.doWork(this);
        }
    }
    
    interface CleaningStrategy{ //State
        enum Type{standard, vacuum, mop};
        void doWork(CleaningBot bot);
    }

    static class StartBot implements CleaningStrategy { //Standard
        CleaningStrategy.Type current = CleaningStrategy.Type.standard;
        public void doWork(CleaningBot bot){
            System.out.println("Started Cleaning Bot");    
        }
    }

    static class VacuumBot implements CleaningStrategy {
        CleaningStrategy.Type current = CleaningStrategy.Type.vacuum;
        public void doWork(CleaningBot bot) {
            System.out.println("Vacuuming!");
        }
    }

    static class MopBot implements CleaningStrategy {
        CleaningStrategy.Type current = CleaningStrategy.Type.mop;
        public void doWork(CleaningBot bot) {
            System.out.println("Mopping!");
        }
    }
}

