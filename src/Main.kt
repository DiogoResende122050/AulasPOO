import java.io.File
import java.util.*

// Definição das classes Livro e Funcionario aqui...

fun main() {
    val livraria = Livraria()
    val scanner = Scanner(System.`in`)
    var isAdmin = false

    println("Bem-vindo à Livraria!")

    while (true) {
        if (!isAdmin) {
            println("\nEscolha uma opção:")
            println("1. Menu do Cliente")
            println("2. Entrar como administrador")
            println("3. Sair")
            print("Opção: ")

            when (scanner.nextInt()) {
                1 -> {
                    println("\nMenu do Cliente:")
                    println("1. Listar livros disponíveis")
                    println("2. Listar todos os livros")
                    println("3. Reservar livro")
                    println("4. Comprar livro")
                    println("5. Sair do menu do cliente")
                    print("Opção: ")

                    // Consumir a quebra de linha pendente
                    //scanner.nextLine()

                    when (scanner.nextInt()) {
                        1 -> livraria.listarLivrosDisponiveis()
                        2 -> livraria.listarTodosLivros()
                        3 -> {
                            print("Digite o título do livro que deseja reservar:")
                            val tituloLivroReserva = readln()
                            livraria.reservarLivro(tituloLivroReserva)
                        }
                        4 -> {
                            print("Digite o título do livro que deseja comprar:")
                            val tituloLivroCompra = readln()
                            print("Digite a quantidade de cópias que deseja comprar:")
                            val quantidadeCompra : Int = readln().toInt()
                            // Consumir a quebra de linha pendente
                            scanner.nextLine()
                            livraria.venderLivro(tituloLivroCompra, quantidadeCompra)
                        }
                        5 -> {
                            println("Voltando ao menu inicial.")
                            continue  // Voltar ao menu do cliente
                        }
                        else -> println("Opção inválida!")
                    }
                }
                2 -> {
                    print("Digite a senha de administrador:")
                    if (scanner.next() == "admin123") {
                        isAdmin = true
                        println("Entrou como administrador.")
                    } else {
                        println("Senha incorreta.")
                    }
                }
                3 -> {
                    println("Até mais!")
                    break
                }
                else -> println("Opção inválida!")
            }
        } else {
            println("\nMenu do Administrador:")
            println("1. Adicionar livro")
            println("2. Adicionar funcionário")
            println("3. Listar livros disponíveis")
            println("4. Listar todos os livros")
            println("5. Listar funcionários")
            println("6. Adicionar livros ao Stock")
            println("7. Apagar livro")
            println("8. Apagar funcionário")
            println("9. Sair como administrador")
            print("Opção: ")

            when (scanner.nextInt()) {
                1 -> {
                    println("Digite o título do livro:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val tituloLivro = readln()
                    println("Digite o nome do autor:")
                    val autor = readln()
                    println("Digite o ano de publicação:")
                    val anoPublicacao = readln().toInt()
                    println("Digite a quantidade inicial:")
                    val quantidade = readln().toInt()
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    livraria.adicionarLivro(Livro(tituloLivro, autor, anoPublicacao, quantidade))
                    println("Livro adicionado com sucesso.")
                }
                2 -> {
                    println("Digite o nome do funcionário:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val nomeFuncionario = readln()
                    println("Digite o cargo do funcionário:")
                    val cargo = readln()
                    livraria.adicionarFuncionario(Funcionario(nomeFuncionario, cargo))
                    println("Funcionário adicionado com sucesso.")
                }
                3 -> livraria.listarLivrosDisponiveis()
                4 -> livraria.listarTodosLivros()
                5 -> livraria.listarFuncionarios()
                6 -> {
                    println("Digite o título do livro que deseja adicionar mais cópias:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val tituloLivroAdicionarCopias = readln()
                    println("Digite a quantidade de cópias que deseja adicionar:")
                    val quantidadeAdicionarCopias: Int = readln().toInt()
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    livraria.adicionarCopiasLivro(tituloLivroAdicionarCopias, quantidadeAdicionarCopias)
                }
                7 -> {
                    println("Digite o título do livro que deseja apagar:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val tituloLivroApagar = readln()
                    livraria.apagarLivro(tituloLivroApagar)
                }
                8 -> {
                    println("Digite o nome do funcionário que deseja apagar:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val nomeFuncionarioApagar = readln()
                    livraria.apagarFuncionario(nomeFuncionarioApagar)
                }
                9 -> {
                    isAdmin = false
                    println("Saiu como administrador.")
                }
                else -> println("Opção inválida!")
            }
        }
    }
}
