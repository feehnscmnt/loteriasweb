/**
 * Função responsável por formatar valores monetários.
 * 
 * @param valor - valor que será formatado
 * 
 */
function formatarValorMonetario(valor) {
	return new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(valor);
}

/**
 * Função responsável pelo modal de mensagens ao usuário.
 * 
 * @param icon - ícone da mensagem no modal
 * @param title - título da mensagem no modal
 * @param message - mensagem do modal
 * 
 */
function responseAlert(icon, title, message) {
	Swal.fire({
		icon: icon,
		title: title,
		text: message
	});
}

/**
 * Função responsável por validar os dados de busca por concurso.
 */
function validarDadosBuscarResultConc() {
	let loteria = PF('slcLoterias').getSelectedValue();
	let concurso = document.getElementById('frmResultadosLoterias:txtConcurso').value;
	
	if (loteria == "" && concurso == "") {
		responseAlert('warning', 'Oops!', 'Selecione a loteria e informe o número do concurso para obter o resultado!');
		return false;
	} else if (loteria == "") {
		responseAlert('warning', 'Oops!', 'Selecione a loteria!');
		return false;
	} else if (concurso == "") {
		responseAlert('warning', 'Oops!', 'Informe o número do concurso!');
		return false;
	}
	
	return true;
}