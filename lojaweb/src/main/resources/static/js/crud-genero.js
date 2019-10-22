"use strict";

function removerAjax(oFormElement, urlDestino){
	
	if(window.confirm("Você realmente deseja remover o registro?!")){
		var http = new XMLHttpRequest();
		http.open(oFormElement.method, oFormElement.action, true);
		
		http.onreadystatechange = function(){
			alert("Status: " + http.readyState);
			if(http.readyState === 4){
				if(http.status === 200){
					alert("Registro removido com sucesso!");
					window.location = urlDestino;
				}else{
					alert("Falha ao remover o registro!")
				}
			}
		}// onreadystatechange
		http.send(new FormData(oFormElement));
	}
	return false;
}

function removerJQuery(id, url){
	swal({
		title: "Deseja realmente remover o registro?",
		text: "Esta ação não poderá ser desfeita!",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		cancelButtonText: "Cancelar",
		confirmButtonText: "Remover",
		closeOnConfirm: false
	}, function(){
		var destino = url + '/' + id;
		$.ajax({
			type: 'DELETE', 
			url: destino,
			success: function(){
				swal({
						title: 'Removido!',
						text: 'Registro removido com sucesso!',
						type: 'success'
				}, function(){
					//window.location = url;
					$('#row_' + id).remove();
				}
				); //fim swal
			},
			error: function(){
				swal({
					title: 'Erro!',
					text: 'Registro não pode ser removido!',
					type: 'error'
			}, function(){
				window.location = url;
				
			}
			); //fim swal
			}
		}); //fim ajax()
	}// fim function swal
		
	); //fim swal
}


function salvar(urlDestino){
	$.ajax({
		type: $('#frm').attr('method'),
		url: $('#frm').attr('action'),
		data: $('#frm').serialize(), //pega todos os dados do form e manda no post
		success: function(){
			swal({
				title: 'Salvo!',
				text: 'Registro salvo com sucesso!',
				type: 'success'
			}, function(){
				window.location = urlDestino;
			});//fim do swal
		},
		error: function(){
			swal('Errou!', 'Falha ao salvar registro!', 'error');
		}
	});//fim do ajax
	return false; // faz com que permaneça na página e lembrar que Ajax é não bloqueante
}
