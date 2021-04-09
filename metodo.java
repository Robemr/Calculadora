package calculadora;


	import java.awt.GridLayout;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	
	/**

	 * Esta clase contiene el programa Calculadora, creada con paneles y botones,
	 * la cual nos permite realizar las operaciones básicas de sumar, restar, dividir y multiplicar.

	 * @author: Roberto L. Mora

	 * @version: 2.0 Entornos 09/4/2021

	 * @see clase#método();

	 */

	public class metodo extends JFrame {

		JTextField ventana;
		double resultado;
		String operacion;

		JPanel panelNumeros, panelOperaciones; //creamos paneles
		boolean nuevaOperacion = true;

//Creamos componentes y botones
		 
		public metodo() {
	
			setSize(400, 400); //Asignamos tamaño
			setTitle("Calculadora");

		
			JPanel panel = (JPanel) this.getContentPane();
	
			ventana = new JTextField("0", 20);

	
			panel.add("North", ventana);

			panelNumeros = new JPanel();
			panelNumeros.setLayout(new GridLayout(4, 4));

			for (int n = 9; n >= 0; n--) {
				Numero("" + n);
			}

			Numero(".");

			panel.add(panelNumeros);

			panelOperaciones = new JPanel();
			panelOperaciones.setLayout(new GridLayout(6, 1));
			
			//Generamos los botones de operaciones y el CE para borrar 
			nuevoBoton("+");
			nuevoBoton("-");
			nuevoBoton("*");
			nuevoBoton("/");
			nuevoBoton("=");
			nuevoBoton("CE");

			panel.add("West", panelOperaciones);

		}

		public void Numero(String digito) {
			JButton boton = new JButton();
			boton.setText(digito);
			boton.addMouseListener(new MouseAdapter() {

				
				public void mouseReleased(MouseEvent event) {
					JButton boton = (JButton) event.getSource();
					numeroPulsado(boton.getText());
				}
			});

			panelNumeros.add(boton);
		}
		
		
	//método para crear los botones y la interfaz MouseListener
	void nuevoBoton(String operacion) {
			JButton boton = new JButton(operacion);

			boton.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					JButton boton = (JButton) event.getSource();
					Pulsar(boton.getText());
				}
			});

			panelOperaciones.add(boton);
		}

		
		public void numeroPulsado(String digito) {
			if (ventana.getText().equals("0") || nuevaOperacion) {
				ventana.setText(digito);
			} else {
				ventana.setText(ventana.getText() + digito);
			}
			nuevaOperacion = false;
		}
		
		//creamos método para la acción que realziza la calculadora pulsando cada tecla
		
		public void Pulsar(String tecla) {
			if (tecla.equals("=")) {
				Resultado();
			} else if (tecla.equals("CE")) {
				resultado = 0;
				ventana.setText("");
				nuevaOperacion = true;
			} else {
				operacion = tecla;
				if ((resultado > 0) && !nuevaOperacion) {
					Resultado();
				} else {
					resultado = new Double(ventana.getText());
				}
			}

			nuevaOperacion = true;
		}
		//creamos metodos de multiplicación, resta, división y resto para pruebas posteriores JUnit
		   public static int multiplicar(int x , int y) {
	             return x * y;
	       }
	       public static int restar(int x, int y) {
	             return x - y;
	       }
	       public static int dividir(int x, int y) {
	             return x / y;
	       }
	       public static int resto(int x, int y) {
	             return x % y;
	       }

//creamos método para el resultado y asignar lo que debe hacer según el signo matématico utilizado
		public void Resultado() {
			if (operacion.equals("+")) {
				resultado += new Double(ventana.getText());
			} else if (operacion.equals("-")) {
				resultado -= new Double(ventana.getText());
			} else if (operacion.equals("/")) {
				resultado /= new Double(ventana.getText());
			} else if (operacion.equals("*")) {
				resultado *= new Double(ventana.getText());
			}

			ventana.setText("" + resultado);
			operacion = "";
		}
	
}
