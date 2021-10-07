package DataStructure;

public class HashTest {
    public Slot[] hashTable;

    public HashTest(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String value;
        Slot(String value){
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int) (key.charAt(0))% this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null){
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null){
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String args[]){
        String name = "JunRoh";
        HashTest hash = new HashTest(20);
        hash.saveData("kkkk", "123213");
        hash.saveData("jun21", "12321333");
        hash.saveData("dsfren", "12321344");
        System.out.println(hash.getData("jun21"));

    }
}
