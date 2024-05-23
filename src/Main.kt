import java.io.File
import java.util.*

// Definição das classes Livro e Funcionario aqui...

class Livraria {
    private val livros = mutableListOf<Livro>()
    private val funcionarios = mutableListOf<Funcionario>()

    init {
        carregarLivrosCSV("data/livros.csv")
        carregarFuncionariosCSV("data/funcionarios.csv")
    }

    fun carregarLivrosCSV(fileName: String) {
        File(fileName).forEachLine { line ->
            val (titulo, autor, anoPublicacao, quantidade) = line.split(',')
            val livro = Livro(titulo, autor, anoPublicacao.toInt(), quantidade.toInt())
            livros.add(livro)
        }
    }

    fun carregarFuncionariosCSV(fileName: String) {
        File(fileName).forEachLine { line ->
            val (nome, cargo) = line.split(',')
            val funcionario = Funcionario(nome, cargo)
            funcionarios.add(funcionario)
        }
    }

    fun salvarLivrosCSV(fileName: String) {
        File(fileName).bufferedWriter().use { out ->
            livros.forEach { livro ->
                out.write("${livro.titulo},${livro.autor},${livro.anoPublicacao},${livro.quantidade}\n")
            }
        }
    }

    fun salvarFuncionariosCSV(fileName: String) {
        File(fileName).bufferedWriter().use { out ->
            funcionarios.forEach { funcionario ->
                out.write("${funcionario.nome},${funcionario.cargo}\n")
            }
        }
    }

    fun adicionarLivro(livro: Livro) {
        livros.add(livro)
        salvarLivrosCSV("data/livros.csv")
    }

    fun adicionarFuncionario(funcionario: Funcionario) {
        funcionarios.add(funcionario)
        salvarFuncionariosCSV("data/funcionarios.csv")
    }

    fun reservarLivro(titulo: String) {
        val livro = livros.find { it.titulo.equals(titulo, ignoreCase = true) }
        if (livro != null && livro.quantidade > 0) {
            livro.quantidade--
            salvarLivrosCSV("data/livros.csv")
            println("Reserva do livro \"$titulo\" feita com sucesso.")
        } else {
            println("Não foi possível fazer a reserva do livro \"$titulo\".")
        }
    }

    fun venderLivro(titulo: String, quantidade: Int) {
        val livro = livros.find { it.titulo.equals(titulo, ignoreCase = true) }
        if (livro != null && livro.quantidade >= quantidade && quantidade > 0) {
            livro.quantidade -= quantidade
            salvarLivrosCSV("data/livros.csv")
            println("$quantidade cópia(s) do livro \"$titulo\" vendida(s) com sucesso.")
        } else if (livro != null && livro.quantidade < quantidade) {
            println("Quantidade insuficiente do livro \"$titulo\" para venda.")
        } else {
            println("Livro \"$titulo\" não encontrado na livraria ou quantidade inválida para venda.")
        }
    }

    fun adicionarCopiasLivro(titulo: String, quantidade: Int) {
        val livro = livros.find { it.titulo.equals(titulo, ignoreCase = true) }
        if (livro != null) {
            livro.quantidade += quantidade
            salvarLivrosCSV("data/livros.csv")
            println("$quantidade cópia(s) do livro \"$titulo\" adicionada(s) com sucesso.")
        } else {
            println("Livro \"$titulo\" não encontrado na livraria.")
        }
    }

    fun listarLivrosDisponiveis() {
        println("Livros Disponíveis:")
        for (livro in livros) {
            if (livro.quantidade > 0) {
                println("${livro.titulo}, ${livro.autor}, ${livro.anoPublicacao}, ${livro.quantidade}")
            }
        }
    }

    fun listarTodosLivros() {
        println("Todos os Livros:")
        for (livro in livros) {
            println("${livro.titulo}, ${livro.autor}, ${livro.anoPublicacao}, ${livro.quantidade}")
        }
    }

    fun listarFuncionarios() {
        println("Funcionários:")
        for (funcionario in funcionarios) {
            println("${funcionario.nome}, ${funcionario.cargo}")
        }
    }
}

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

            when (scanner.nextInt()) {
                1 -> {
                    println("\nMenu do Cliente:")
                    println("1. Listar livros disponíveis")
                    println("2. Listar todos os livros")
                    println("3. Reservar livro")
                    println("4. Comprar livro")
                    println("5. Sair do menu do cliente")

                    // Consumir a quebra de linha pendente
                    scanner.nextLine()

                    when (scanner.nextInt()) {
                        1 -> livraria.listarLivrosDisponiveis()
                        2 -> livraria.listarTodosLivros()
                        3 -> {
                            println("Digite o título do livro que deseja reservar:")
                            val tituloLivroReserva = scanner.nextLine()
                            livraria.reservarLivro(tituloLivroReserva)
                        }
                        4 -> {
                            println("Digite o título do livro que deseja comprar:")
                            val tituloLivroCompra = scanner.nextLine()
                            println("Digite a quantidade de cópias que deseja comprar:")
                            val quantidadeCompra = scanner.nextInt()
                            // Consumir a quebra de linha pendente
                            scanner.nextLine()
                            livraria.venderLivro(tituloLivroCompra, quantidadeCompra)
                        }
                        5 -> {
                            println("Voltando ao menu do cliente.")
                            continue  // Voltar ao menu do cliente
                        }
                        else -> println("Opção inválida!")
                    }
                }
                2 -> {
                    println("Digite a senha de administrador:")
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
            println("7. Sair como administrador")

            when (scanner.nextInt()) {
                1 -> {
                    println("Digite o título do livro:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val tituloLivro = scanner.nextLine()
                    println("Digite o nome do autor:")
                    val autor = scanner.nextLine()
                    println("Digite o ano de publicação:")
                    val anoPublicacao = scanner.nextInt()
                    println("Digite a quantidade inicial:")
                    val quantidade = scanner.nextInt()
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    livraria.adicionarLivro(Livro(tituloLivro, autor, anoPublicacao, quantidade))
                    println("Livro adicionado com sucesso.")
                }
                2 -> {
                    println("Digite o nome do funcionário:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val nomeFuncionario = scanner.nextLine()
                    println("Digite o cargo do funcionário:")
                    val cargo = scanner.nextLine()
                    livraria.adicionarFuncionario(Funcionario(nomeFuncionario, cargo))
                    println("Funcionário adicionado com sucesso.")
                }
                3 -> livraria.listarLivrosDisponiveis()
                4 -> livraria.listarTodosLivros()
                5 -> livraria.listarFuncionarios()
                6 -> {
                    println("Digite o título do livro que deseja adicionar mais cópias:")
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    val tituloLivroAdicionarCopias = scanner.nextLine()
                    println("Digite a quantidade de cópias que deseja adicionar:")
                    val quantidadeAdicionarCopias = scanner.nextInt()
                    scanner.nextLine() // Consumir a quebra de linha pendente
                    livraria.adicionarCopiasLivro(tituloLivroAdicionarCopias, quantidadeAdicionarCopias)
                }
                7 -> {
                    isAdmin = false
                    println("Saiu como administrador.")
                }
                else -> println("Opção inválida!")
            }
        }
    }
}
