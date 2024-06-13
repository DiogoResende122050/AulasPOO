open class Funcionario(val nome: String, val cargo: String) {
    open fun apresentar() {
        println("Nome: $nome, Cargo: $cargo")
    }
}

class Gerente(nome: String) : Funcionario(nome, "Gerente") {
    override fun apresentar() {
        println("Nome: $nome (Gerente)")
    }
}

class Cliente(nome: String) : Funcionario(nome, "Cliente")
