package strategy;

public class SaveContext implements SaveStrategy{
	private SaveStrategy strategy;
	 public SaveContext() {
	        
	    }
   public SaveContext(SaveStrategy strategy) {
       this.strategy = strategy;
   }

   public void setStrategy(SaveStrategy strategy) {
       this.strategy = strategy;
   }

   public void save( String filePath) {
       strategy.save( filePath);
   }
}
