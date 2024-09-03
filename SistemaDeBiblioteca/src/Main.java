import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();
		Scanner scanner = new Scanner(System.in);

		// Adicionando alguns livros e usuários para teste
		biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien"));
		biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));
		biblioteca.adicionarUsuario(new Usuario("Alice"));
		biblioteca.adicionarUsuario(new Usuario("Bob"));

		// Interação com o usuário
		while (true) {
			System.out.println("1. Alugar Livro");
			System.out.println("2. Devolver Livro");
			System.out.println("3. Sair");
			System.out.println("Escolha uma opção");
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir anova linha

			if (opcao == 1) {
				System.out.println(("Diigite o nome do usuario"));
				String nomeUsuario = scanner.nextLine();
				Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

				if (usuario != null) {
					System.out.println("Digite o titulo do livro: ");
					String tituloLivro = scanner.nextLine();
					Livro livro = biblioteca.buscarLivro(tituloLivro);

					if (livro != null) {
						usuario.alugarLivro(livro);
					} else {
						System.out.println("Livro nao encontrado.");
					}
				} else {
					System.out.println("Usuario nao encontrado.");
				}
			} else if (opcao == 2) {
				System.out.println("Digite o nome do usuario");
				String nomeUsuario = scanner.next();
				Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

				if (usuario != null) {
					usuario.devolverLivro();
				} else {
					System.out.println("Usuario nao encontrado.");
				}
			} else if (opcao == 3) {
				System.out.println("saindo...");
				break;
			} else {
				System.out.println("opcao invalida.");
			}
		}
		scanner.close();
	}
}
