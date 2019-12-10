// $(document).ready(function() {
//     function limpa_formulário_cep() {
//         // Limpa valores do formulário de cep.
//         $("#logradouro").val("");
//         $("#cidade").val("");
//         $("#uf").val("");
//     }
//     //Quando o campo cep perde o foco.
//     $("#cep").blur(function() {
//         //Nova variável "cep" somente com dígitos.
//         var cep = $(this).val().replace(/\D/g, '');
//         //Verifica se campo cep possui valor informado.
//         if (cep != "") {
//             //Expressão regular para validar o CEP.
//             var validacep = /^[0-9]{8}$/;
//             //Valida o formato do CEP.
//             if(validacep.test(cep)) {
//                 //Preenche os campos com "..." enquanto consulta webservice.
//                 $("#logradouro").val("...");
//                 $("#cidade").val("...");
//                 $("#uf").val("...");
//                 console.log(cep);
//                 $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?").done(function(dados) {
//                     if (!("erro" in dados)) {
//                         $("#logradouro").val(dados.logradouro);
//                         $("#cidade").val(dados.localidade);
//                         $("#uf").val(dados.uf);
//                     } else {
//                         limpa_formulário_cep();
//                         alert("CEP não encontrado.");
//                     }
//                 });
//             } else {
//                 limpa_formulário_cep();
//                 alert("Formato de CEP inválido.");
//             }
//         } else {
//             //cep sem valor, limpa formulário.
//             limpa_formulário_cep();
//         }
//     });
// });