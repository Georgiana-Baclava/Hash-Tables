package map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import list.ValueList;
import list.EntryNode;
import list.EntryList;
import list.ValueNode;

/**
 * @author Georgiana
 * 
 */

public class HashMap extends AbstractHashMap {

	EntryList[] buckets;
	int size = 0;
	
	public HashMap(int n) {
		buckets = new EntryList[n];
		
		  for (int i = 0; i < n; i++) { 
			  buckets[i] = new EntryList(); 
		  }
		 
		 
	}

	public ValueList get(Key key) {
		int i = ((MyKey)key).hashCode();System.out.println("i=" + i);
		EntryNode first_en = buckets[i].getFirstEqual(key);
			if (first_en != null){
				//System.out.println("maia");
				return first_en.val_list;
			}
			//System.out.println("oaie");
		return null;

	}

	public boolean containsKey(Key key) {
		int i = ((MyKey)key).hashCode();
		EntryNode first_en = buckets[i].getFirstEqual(key);
		if (first_en != null)
			return true;
		return false;
	}

	public boolean put(Key key, Value value) {
		if (size == buckets.length) {
			EntryList [] buckets1 = new EntryList[2*buckets.length];
			for(int k = 0; k < buckets.length; k++)
				buckets1[k] = buckets[k];
			buckets = buckets1;
		}
		int i = ((MyKey)key).hashCode();System.out.println("hashcode=" + i);
		EntryNode first_en = buckets[i].getFirstEqual(key);
		if( first_en == null ) {
			if(buckets[i].size() == 0)
				size++;
			buckets[i].add(key);//System.out.println("rez:" + buckets[i].toString());
			//EntryNode first_en1 = buckets[i].getFirstEqual(key);
			//System.out.println("boia");
			buckets[i].node.val_list.add(value); //System.out.println("ana");
			//System.out.println(buckets[i].node.val_list.toString());
			//System.out.println("size=" + buckets[0].node.val_list.size());
			return true;
		}
		else {
			System.out.println("hai");
			ValueNode first_val = first_en.val_list.getFirstEqual(value);
			if (first_val == null){
				ValueNode v = first_en.val_list.getSortedPosition(value);
				
				if (v == null){
					System.out.println("vaca");//aici pt iser la sf
					first_en.val_list.add(value);
				}
				else {
					first_en.val_list.insertBefore(v, value);
				}
				System.out.println("val_size" + first_en.val_list.size());
				//System.out.println(first_en.val_list.toString());
				//System.out.println("rez:" + buckets[i].toString());
				return false;
			}
			(first_val.no)++;
			System.out.println("val_size" + first_en.val_list.size());
			System.out.println(first_en.val_list.toString());
			return false;	
		}
		
	}

	public int remove(Key key, Value value) {
		int i = ((MyKey)key).hashCode();
		int no = 0;
		EntryNode first_en = buckets[i].getFirstEqual(key);
		if( first_en != null) {
			ValueNode first_val = first_en.val_list.getFirstEqual(value);
			if (first_val == null)
				return no;
			no = first_val.no;
			first_en.val_list.remove(first_val);
			if (first_en.val_list.size() == 0)
				buckets[i].remove(first_en);
		//remove 
		return no;
		}
		return no;
	}

	public ValueList remove(Key key) {
		ValueList new_list = new ValueList();
		int i = ((MyKey)key).hashCode();
		EntryNode first_en = buckets[i].getFirstEqual(key);
		if (first_en == null){
			System.out.println("greseala");
			return null;
		}
			new_list = first_en.val_list;
			if(new_list == null) return null;
			//System.out.println(new_list.toString());
			//System.out.println(buckets[i].toString());
			buckets[i].remove(first_en);
			System.out.println(new_list.toString());
			System.out.println(":))");
			System.out.println("esti proasta");
			return new_list;
	
		
		//return null;
	}

	
	 public static void main (String[] args) { 
	  	
	  	BufferedReader in = null;
	  	BufferedWriter writer = null;
	  	
        try {
            in = new BufferedReader(new FileReader(args[0]));
            File out = new File("output.txt");
    	  	out.createNewFile();
            writer = new BufferedWriter(new FileWriter(out));
            String line = null;
            int n = Integer.parseInt(in.readLine());
            System.out.println("n=" + n);
            HashMap m = new HashMap(n); //n nr de operatii din fisier
            //constructor de n buckets
            while ((line = in.readLine()) != null) {
            	
            	String [] parts = line.split("\\s");
            	int op = Integer.valueOf(parts[0]);
            	System.out.println("op=" + op);
            	if (op == 0) {
            		ValueList new_list = new ValueList();
            		MyKey key = new MyKey();
            		key.setKey(parts[1]);
            		//System.out.println(m.get(key).toString());
            		new_list = m.get(key);
            		if (new_list == null)
            			writer.write("null");
            		else writer.write(new_list.toString());
            		writer.newLine();
            	}
            	if(op == 1) {
            		MyKey key = new MyKey();
            		key.setKey(parts[1]);
            		MyValue val = new MyValue();
            		val.setVal(parts[2]);
            		m.put(key, val);//verificare
            		//System.out.println((m.buckets[0].node.val_list.toString()));
            	}
            	if(op == 2) {
            		MyKey key = new MyKey();
            		key.setKey(parts[1]);
            		if(m.containsKey(key)) {
            			writer.write("true");
            			
            		}
            		else {
            			writer.write("false");
            			
            		}
            		writer.newLine();
            	}
            	if(op == 3) {
            		ValueList new_list = new ValueList();
            		MyKey key = new MyKey();
            		key.setKey(parts[1]);
            		new_list = m.remove(key);
            		if (new_list == null){
            			writer.write("null");System.out.println("salut");}
            		else{
            			System.out.println("of");
            			//new_list = m.remove(key);
            			//if (new_list == null) System.out.println("fuga");
            			//System.out.println(new_list.toString());
            			writer.write(new_list.toString());
            			}
            		writer.newLine();
            	}
            	if(op == 4) {
            		MyKey key = new MyKey();
            		key.setKey(parts[1]);
            		MyValue val = new MyValue();
            		val.setVal(parts[2]);
            		int no = m.remove(key, val);
            		System.out.println(no);
            		writer.write(String.valueOf(no));
            		writer.newLine();
            		//scrie no in out
            	}
            }
        } catch(IOException e) {
            e.printStackTrace();

        } finally {
            if (in != null) {
                try {
                    in.close();

                } catch (IOException e) {
                    // error closing file: oh well...
                }
            }
            if (writer != null) {
                try {
                    writer.close();

                } catch (IOException e) {
                    // error closing file: oh well...
                }
            }
        }
	 }
	 

}
