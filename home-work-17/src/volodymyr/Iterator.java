package volodymyr;

public interface Iterator {

	public boolean hasNext();
	public Object next();
}
	
	class Collection {
		private static Object[]arr;
		Collection(Object [] arr){
			Collection.arr = arr;
		}
		
		public class Forward implements Iterator{
			
			private int count = 0;
			
			@Override
			public boolean hasNext() {
				return count<arr.length;
			}
			
			@Override
			public Object next() {
				return arr[count++];
			}
		}
		
		public Forward createForward(){
			return new Forward();
		}
	
		public class Backward implements Iterator{
			int count = arr.length -1;
			
			@Override
			public boolean hasNext() {
				return count>=0;
			}
			
			@Override
			public Object next() {
				return arr[count--];
			}
		}
		
		public Backward createBackward() {
			return new Backward();
		}
		
		public Iterator createAnonimous() {
			return new Iterator() {
				public int count = arr.length-1;

				@Override
				public boolean hasNext() {
					return count>=0;
				}

				@Override
				public Object next() {
					return arr[count--];
				}
			};
		}
		
		public Iterator createLocal() {
			class localIterator implements Iterator{
				private int count = 0;

				@Override
				public boolean hasNext() {
					return count < arr.length;
				}

				@Override
				public Object next() {
					return arr[count++];
				}
			}
			return new localIterator();
		}
		
		public static class staticIterator implements Iterator{
			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < arr.length;
			}

			@Override
			public Object next() {
				return arr[count++];
			}
			
		}
		
		public static staticIterator createStaticIterator() {
			return new staticIterator();
		}
}