package modelo;

public class PicaFija {

	private int[] numero; // Numero en digitos
	private int[][] intentos;
	private String usuario;
	private boolean gano;
	private int conteo;
	private int picas;
	private int fijas;

	public PicaFija(int[] numero, String usuario) {
		this.numero = numero;
		this.usuario = usuario;
		this.intentos = new int[10][this.numero.length];
		this.conteo = 0;
	}

	public boolean validar(int[] intento) {
		if (intento.length == this.numero.length) {
			for (int i = 0; i < this.numero.length; ++i) {
				for (int j = 0; j < this.numero.length; ++j) {

					boolean mismaPosicion = (i == j);
					boolean mismoNumero = (intento[i] == intento[j]);
					if (!mismaPosicion && mismoNumero) {
						return false;
					}

				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void intentar(int[] intento) {
		picas = 0;
		fijas = 0;

		for (int i = 0; i < this.numero.length; ++i) {
			for (int j = 0; j < this.numero.length; ++j) {
				if (intento[i] == this.numero[j] && (i == j)) {
					++fijas;
				} else if (intento[i] == this.numero[j]) {
					++picas;
				}
			}
		}
		if (fijas == this.numero.length) {
			this.gano = true;
		} else if (this.conteo == 9) {
			this.gano = false;
		}

		this.conteo++;
	}

	public int[] obtenerNumero() {
		return numero;
	}

	public int[][] obtenerIntentos() {
		return intentos;
	}

	public String obtenerUsuario() {
		return usuario;
	}

	public boolean obtenerGano() {
		return gano;
	}

	public int obtenerConteo() {
		return this.conteo;
	}
	public int obtenerPicas() {
		return this.picas;
	}
	public int obtenerFijas() {
		return this.fijas;
	}

}
