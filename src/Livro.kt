// Livro.kt
open class Livro(val titulo: String, val autor: String, val anoPublicacao: Int, var quantidade: Int = 0) {
    open fun detalhes() {
        println("Título: $titulo, Autor: $autor, Ano de Publicação: $anoPublicacao, Quantidade Disponível: $quantidade")
    }
}

class LivroInfantil(titulo: String, autor: String, anoPublicacao: Int, quantidade: Int) :
    Livro(titulo, autor, anoPublicacao, quantidade) {
    override fun detalhes() {
        super.detalhes()
        println("Tipo: Infantil")
    }
}

class LivroDidatico(titulo: String, autor: String, anoPublicacao: Int, quantidade: Int) :
    Livro(titulo, autor, anoPublicacao, quantidade) {
    override fun detalhes() {
        super.detalhes()
        println("Tipo: Didático")
    }
}
