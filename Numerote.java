public class Numerote {

	private byte [] numerote;
	private boolean signo;

	public Numerote(){

		numerote =new byte[1];
		numerote[0]=0;
		signo = true;  

	}

	public Numerote(String a){

		signo = true;

		if (a.charAt(0) == '+' || a.charAt(0) == '-') {

			if (a.charAt(0) == '+') {

				signo = true;

			} else if (a.charAt(0) == '-') {

				signo = false;

			}

			a = a.substring(1);
		}


		numerote = new byte [a.length()];

		try{

			for(int i = 0;i < a.length(); i++){

				numerote[i]=Byte.parseByte(a.charAt(a.length()-1-i)+"");

			}


		}
		catch(Exception e){

			System.out.println("Errorrr" + e.getMessage());

		}

	}

	public Numerote suma(Numerote a){


		return new Numerote("00");

	}

	public Numerote resta(Numerote numero){


		Numerote resultado = new Numerote(this.toString());
		byte temp = 0;

		for(int i = 0; i < numerote.length && i < numero.numerote.length; i++) {

			if (this.numerote[i] < numero.numerote[i] && (numerote.length <= numero.numerote.length)) {

				resultado.numerote[i] = (byte)(this.numerote[i] - numero.numerote[i]);

			} else if (this.numerote[i] < numero.numerote[i]) {

				temp = (byte)(10 + this.numerote[i]);
				resultado.numerote[i] = (byte)(temp - numero.numerote[i]);
				temp = (byte)(temp / 10);
				continue;

			} else {

				resultado.numerote[i]  = (byte)(this.numerote[i] - numero.numerote[i]);
				temp = (byte)0;

			}


		}

		if ((numerote.length > numero.numerote.length) && temp == (byte)1) {

			resultado.numerote[numerote.length-1]  = (byte)(this.numerote[numerote.length-1] - (byte)temp);

		}

		return resultado;

	}

	public Numerote multiplica(Numerote a){

		return new Numerote("00");

	}

	public String toString(){

		StringBuffer palabra= new StringBuffer();

		for(int i = 0; i < this.numerote.length; i++){

			palabra.append(this.numerote[this.numerote.length-1-i]);

		}

		return palabra.toString();

	}

	public static void main(String []args){


		Numerote tnum = new Numerote("17342567897057946835726514356789067958437625143546789065473625");
		Numerote no = new  Numerote("12342567897057946835726514356789067958437625143546789065473625");
		System.out.println("Resta de num1-num2: " + tnum.resta(no));


		System.out.println(" ");

		Numerote num1 = new Numerote("10");
		Numerote num2 = new Numerote("2");
		System.out.println("Resta de num1-num2: " + num1.resta(num2));

		System.out.println(" ");

		num1 = new Numerote("784");
		num2 = new Numerote("143");
		System.out.println("Resta de num1-num2: " + num1.resta(num2));

		System.out.println(" ");

		num1 = new Numerote("100");
		num2 = new Numerote("50");
		System.out.println("Resta de num1-num2: " + num1.resta(num2));

		System.out.println(" ");

		num1 = new Numerote("78431509735821789571623213209");   //este todavia no esta 
		num2 = new Numerote("93236412621465972356736921327");
		System.out.println("Resta de num1-num2: " + num1.resta(num2));
		
		System.out.println(" ");

		num1 = new Numerote("0");
		num2 = new Numerote("2");
		System.out.println("Resta de num1-num2: " + num1.resta(num2));
	}

}
