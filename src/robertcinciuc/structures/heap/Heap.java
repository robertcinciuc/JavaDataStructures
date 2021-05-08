package robertcinciuc.structures.heap;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Heap {

    protected List<Integer> elements;

//    Max heap
    public Heap(){
        this.elements = new ArrayList<Integer>();
    }

    public void insert(Integer elem){
        this.elements.add(elem);
        this.compareUp(elem, this.elements.size() - 1);
    }

    public void compareUp(Integer elem, int pos){

        Integer parent;
        if(pos > 0){
            int parentPos = (int)(Math.floor( 1.0*(pos - 1)/2 ));
            parent = this.elements.get(parentPos);

            if( parent.compareTo(elem) < 0 ){
                Integer tmp = parent;
                this.elements.set(parentPos, elem);
                this.elements.set(pos, tmp);
                compareUp(elem, parentPos);
            }
        }
    }

//    TODO: fix this method
    public void compareDown(Integer elem, int pos){

        int chosenPos = 0;
        if(this.elements.size() > 0) {
            if (pos * 2 + 2 < this.elements.size()) {
                if (this.elements.get(pos * 2 + 1).compareTo(this.elements.get(pos * 2 + 2)) >= 0) {
                    chosenPos = pos * 2 + 1;
                } else {
                    chosenPos = pos * 2 + 2;
                }
            } else if (pos * 2 + 1 < this.elements.size()) {
                chosenPos = pos * 2 + 1;
            } else {
                return;
            }

            Integer chosenChild = this.elements.get(chosenPos);
            if(elem.compareTo(chosenChild) <= 0) {
                this.elements.set(chosenPos, elem);
                this.elements.set(pos, chosenChild);
                this.compareDown(chosenChild, chosenPos);
            }else{
                return;
            }
        }else{
            return;
        }
    }

    public void printOnLevels(){
        int levelLimit = 1;
        int count = 0;
        while(count < this.elements.size()){
            int lvlCount = 0;
            while(lvlCount < levelLimit && count < this.elements.size()){
                System.out.print(this.elements.get(count) + " ");
                count += 1;
                lvlCount += 1;
            }
            System.out.println();
            levelLimit *= 2;
        }
    }

    public void printSimple(){
        for(Integer elem: this.elements){
            System.out.print(elem + " ");
        }
    }

    public Integer deleteTop(){
        Integer result = this.elements.get(0);

        this.elements.set(0, this.elements.get(this.elements.size() - 1));
        this.elements.remove(this.elements.size() - 1);

        this.compareDown(this.elements.get(0), 0);
        return result;
    }

    public List<Integer> getSorted(){

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while(count < this.elements.size()){
            result.add(this.deleteTop());
            count += 1;
        }

        return result;
    }
}
