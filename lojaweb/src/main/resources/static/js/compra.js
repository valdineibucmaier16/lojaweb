$(document).ready(function(){
	
	$.getJSON("http://localhost:8025/categoria/json", function(dados) {
		
		
		var itens = [];
		var opcoes = '<option value="">escolha uma categoria</option>';
		
		$.each(dados, function(key, val) {
			opcoes += '<option value="' + val.nome + '">' + val.nome + '</option>';
		});
		
		$("#categorias").html(opcoes);
					
});
	
});


$("#categorias").change(carregarAssuntos);

function carregarAssuntos(){
  $.getJSON("http://localhost:8025/assunto/json", function(dadosAssunto) {
	
	
	var opcoes_assuntos = '<option value="">escolha uma assunto</option>';
	var str = "";
	
	$("#categorias option:selected").each(function() {
		str += $(this).text();
		
	});
	
	$.each(dadosAssunto, function(key, val){
		if(val.categoria.nome == str){
			
			opcoes_assuntos += '<option value="' + val.nome + '">' + val.nome + '</option>';
		}
	})
	
	$("#assuntos").html(opcoes_assuntos);
	
	
})	
}


$("#assuntos").change(carregarLivros);

function carregarLivros(){
  $.getJSON("http://localhost:8025/livro/json", function(dadosLivro) {
	
	
	var opcoes_livros = '<option value="">escolha um livro</option>';
	var strl = "";
	
	$("#assuntos option:selected").each(function() {
		strl += $(this).text();
		
	});
	
	$.each(dadosLivro, function(key, val){
		console.log(val.assunto.nome);
		console.log(strl);
		if(val.assunto.nome == strl){
			
			opcoes_livros += '<option value="' + val.titulo + '">' + val.titulo + '</option>';
			
		}
	})
	
	$("#livros").html(opcoes_livros);
	
	
})	
}

$("#btn-adicionar").click(adicionarItem);

function adicionarItem(){
	var corpoTabela = $("#tabelaItens").find("tbody");
	
	var valor = $("#livros option:selected").val();
	
	var linha = "<tr>"+ 
					"<td>"+ valor + "</td>"+
					"<td>"+  + "</td>"+
				"</tr>";
	
	corpoTabela.append(linha);
	
}

