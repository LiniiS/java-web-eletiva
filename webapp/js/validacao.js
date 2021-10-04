/**
 * validações estilizadas
 */

export function valida(input){
    const tipoDeInput = input.dataset.tipo
//    var forms = document.getElementsByClassName('needs-validation');

    if(validadores[tipoDeInput]){
        validadores[tipoDeInput](input)
    }
    //para mostrar a mensagem customizada de erro é preciso manipular
    //a classe invalid-feedback e valid-feedback na div dentro do input
    /*
    if(input.validity.valid){
        input.parentElement.classList.remove('invalid-feedback')
    }else{
        input.parentElement.classList.add('invalid-feedback')
    }
    */
    //essa validação não está funcionando, apenas a default do browser
    //é preciso verificar melhor essa validação customizada, usar a msg default do navegador
}

//objeto com os tipos dos validadores
const validadores = {
    dtNascimento: input => validaDataNascimento(input),
   // nome: input => validaNome(input)
     marcha: input => validaMarcha(input),
     portas: input => validaPortas(input)
}

function validaMarcha(input){
    let mensagem = ''
    const marchaRecebida = input.value

    if(!ehMarchaValida(marchaRecebida)){
        mensagem = 'Marcha inválida'
    }
    input.setCustomValidity(mensagem)
}

function ehMarchaValida(marcha){
    const marchaLimite = 10 //para carros comuns e motos
    const marchaInput = marcha

    return marchaInput <= marchaLimite
}
function validaPortas(input){
    let mensagem= ''
    const numeroPortas = input.value

    if(!quantidadeValidaDePortas(numeroPortas)){
        mensagem = 'Quantidade de portas inválida'
    }
    input.setCustomValidity(mensagem)
}

function quantidadeValidaDePortas(portas){
    const qntdeLimite = 5 // com porta-malas
    const qntdeInput = portas

    return qntdeInput <= qntdeLimite
}



function validaDataNascimento(input){
    const dataRecebida = new Date(input.value)
    let mensagem = ''
    
    if(!maiorQue18(dataRecebida)){ 
        mensagem = 'Apenas maiores de 18 anos'

    }
    //propriedade do input setCustomValidity
    input.setCustomValidity(mensagem)


}

function maiorQue18(data){
    const dataAtual = new Date() //coloca data de hj

    const dataMais18 = new Date(data.getUTCFullYear() + 18, data.getUTCMonth(), data.getUTCDate())

    return dataMais18 <= dataAtual
}
