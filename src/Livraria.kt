import java.io.File
import java.util.*

/*class Livraria {
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
*/