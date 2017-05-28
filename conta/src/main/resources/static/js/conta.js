$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal:',', thousands:'.', allowZero: false, allowNegative: true});
	
	$('.js-atualizar-status').on('click', function(event){
		event.preventDefault();
		
		var bt	 	= $(event.currentTarget);
		var urlReceber		= bt.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT',
			
		});
		
		response.done(function(e){
			var codigo = bt.data('codigo');
			$('[data-role=' + codigo + ']').html('<span class="label label-success">'+ e +'</span>');
			bt.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro recebendo cobrança');
		});
		
		//console.log('URL>>>', url);
	});
});