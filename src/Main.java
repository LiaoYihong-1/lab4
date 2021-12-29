import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        String choice;
        Scanner input=new Scanner(System.in);
        Grassland goodgra =new Grassland("flat grassland",Feature.FLAT);
        Grassland badgra  =new Grassland("Not flat grassland",Feature.UNEVEN);
        River river = new River("river");
        CR Robin=new CR("Christopher Robin",38,Sex.MALE);
        Normalmember Sashka=new Normalmember("Sashka Bug",32,Sex.MALE);
        PO Pooh=new PO("Pooh",29,Sex.MALE);
        Normalmember A=new Normalmember("Tom",35,Sex.MALE);
        Normalmember B=new Normalmember("ИА-иа",27,Sex.MALE);
        Expedition expedition=new Expedition("expedition");
        Expedition.action actionofex=expedition.new action();

        try{
            expedition.addmember(Robin);
            expedition.addmember(Pooh);
            expedition.addmember(Sashka);
            expedition.addmember(A);
            expedition.addmember(B);
        }catch (RuntimeException e){
            Human help []=expedition.inexpediton;
            expedition.inexpediton=new Human[expedition.number+1];
            expedition.adjust(help[0]);
            expedition.adjust(help[1]);
            expedition.adjust(help[2]);
            expedition.adjust(help[3]);
            expedition.adjust(B);
            expedition.number=expedition.inexpediton.length-1;
            /*System.out.printf("more people is ok\n");
            for(int i=0;i<expedition.inexpediton.length;i++){
                System.out.print(expedition.inexpediton[i]+"\n");
            }*/
        }

        actionofex.walkto(river);
        actionofex.arrive(river);
        Robin.estimate();
        river.Flow();
        Pooh.ambushis();

        Expedition.destination current=new Expedition.destination("a flat grassland");
        current.showdes();
        expedition.crossshore("shore",Feature.NARROW);
        expedition.crossshore("shore",Feature.WIDE);
        do{
            System.out.print("Now they arrived at:");
            choice=input.nextLine();
            if(choice.equals("good grassland")||choice.equals("flat grassland")){
                Robin.stayornot(goodgra);
            }else{
                try {
                    Robin.stayornot(badgra);
                }catch (GrassLandNotFlatException e){
                    badgra.getfeature();
                    Robin.say("keep moving\n");
                }
            }
        }while(!(choice.equals("good grassland")||choice.equals("flat grassland")));

        input.close();
        Robin.sit();
        Pooh.sit();
        A.sit();
        B.walkto(Pooh);
        B.eat("dinner");

        new Expedition.destination("where they from").showdes();
    }
}

