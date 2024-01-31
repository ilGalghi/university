package fratm;

import java.util.TreeSet;


public class Numeri {
	static TicketCell[] T = new TicketCell[15];
	
	void Crea() {
		String[] smorfia = {"l'Italia","'A piccerella","'A jatta","'O puorco","'A mana","Chella ca\nguarda nderra",
				            "'O vasetto","'A Madonna","'A figliata","'E fasule","'E surice","'E surdate","Sant'Antonio",
				            "'O 'mbriaco","'O guaglione","'O culo","'A disggrazia","'O sanghe","'A resata","'A festa",
				            "'A femmena \nannuda", "'O pazzo","'O scemo","'E Gguardie","Natale","Nanninella","'O càntaro",
				            "'E zizze","'O pate d''e\nccriature","'E palle \nd''o tenente","'O patrone \n'e casa","'O capitone",
				            "L'anne 'e \nCristo","'A capa","L'aucielle","'E \ncastagnelle","'O monaco","'E mazzate","'A funa \n'nganna",
				            "'A paposcia","'O curtiello","'O ccafé","Onna o \nbalcone","'E cancelle","'O vino \nbbuono","'E denare",
				            "'O muorto","'O muorto \nche pparla","'O piezzo 'e\n carne","'O ppane","'O ciardino","'A mamma",
				            "'O viecchio","'O cappiello","'A musica","'A caduta","'O \nscartellato","'O paccotto","'E pile",
				            "'O lamiento","'O cacciatore","'O muorto \naccise","'A sposa","'A sciammeria","'O chianto","'E ddoje \nzetelle",
				            "'O purpo into\n'a chitarra","'A zuppa \ncotta","sott'e \n'ncoppa","'O palazzo","L'ommo 'e \nmmerda","'A maraviglia",
				            "'O spitale","'A rotta","Pulecenella","'A funtana","'E diavulille","'A bella \nfigliola","'O mariuolo",
				            "'A vocca","'E sciure","'A tavula \n'mbandita","'O maletiempo","'A chiesa","Ll'aneme d''o \npriatorio",
				            "'A puteca","'E perucchie","'E \ncasecavalle","'A vecchia","'A paura"};
		Estrazione.smorfia = smorfia;
		TreeSet<Integer> lista = new TreeSet<Integer>();
		int j = 1;
		int x;
		while(lista.size() != 15) {
			x = (int)(Math.random()*90+1);
			if(!lista.contains(x)) {
				lista.add(x);
			}
		}
		for(int i = 0; i < 15; i++ ) {
			T[i].setValue(lista.first(),smorfia[lista.first()-1]);
			lista.remove(lista.first());
			T[i].setSelected(false);
		}
		return;
	}

}
