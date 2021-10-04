/**
 * 
 */

import { valida } from './validacao.js'

const inputs = document.querySelectorAll('input')

//pra cada input que foi selecionado, o evento blur é chamado e aciona a função "valida" cm o elemento no target
inputs.forEach(input => {
    input.addEventListener('blur', (evento) => {
        valida(evento.target)
    })
})
