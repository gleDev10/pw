Index = function () {

};

Index.Load = function () {
    var index = new Index();
    index.initialize();
    return index;
};

Index.prototype = {
    initialize: function () {

        $('#btnSalvar').bind('click', '', $.createDelegate(this, this._salvarClick));

        this._obterVeiculos();
    },
    _obterVeiculos: function () {

        $('#tabela').html('');
        this.dataBind(
                'GET',
                '',
                '/api/veiculo',
                this._obterVeiculosSuccess,
                this._obterVeiculosError);
    },
    _obterVeiculosSuccess: function (value) {

        var tabela = '<tr>';
        tabela += '<td>Id</td>';
        tabela += '<td>Marca</td>';
        tabela += '<td>Modelo</td>';
        tabela += '<td>Placa</td>';
        tabela += '<td>Cor</td>';
        tabela += '</tr>';

        $("#tabela").append(tabela);

        for (var i = 0; i < value.length; i++) {

            tabela = '<tr>';
            tabela += '<td>';
            tabela += value[i].id;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].marca;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].modelo;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].placa;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].cor;
            tabela += '</td>';
            tabela += '<td>';
            tabela += '<input type="button" id="btnExcluir' + value[i].id + '" value="Excluir" />';
            tabela += '<input type="button" id="btnAlterar' + value[i].id + '" value="Alterar" />';
            tabela += '</td>';
            tabela += '</tr>';

            $('#tabela').append(tabela);

            // objeto item parâmetro para excluir
            var item = {
                id: value[i].id
            };

            $('#btnExcluir' + value[i].id).bind('click', item, $.createDelegate(this, this._excluirClick));
            $('#btnAlterar' + value[i].id).bind('click', item, $.createDelegate(this, this._alterarClick));
        }

    },
    
    _obterVeiculosError: function () {
        alert('Ops... algo deu errado. Tente novamente. _obterVeiculosError');
    },

    _alterarClick: function (value) {
        this.dataBind('GET', null,
                '/api/veiculo/' + value.data.id,
                this._alterarClickSuccess,
                this.alterarClickError
                );
        alert("Você está alterando o veículo: " + value.data.id);
    },

    _alterarClickSuccess: function (value) {
        $('#id').val(value.id);
        $('#marca').val(value.marca);
        $('#modelo').val(value.modelo);
        $('#placa').val(value.placa);
        $('#cor').val(value.cor);        
    },

    _alterarClickError: function (value) {

        alert("Erro ao alterar");
    },
    
    _excluirClick: function (value) {
        // console.log('/api/veiculo/' + value.data.id);
        this.dataBind(
                'DELETE',
                '',
                '/api/veiculo/' + value.data.id,
                this._obterVeiculos,
                this._obterVeiculosError);
    },
    _salvarClick: function () {

        var data = {
            id: $('#id').val(),
            marca: $('#marca').val(),
            modelo: $('#modelo').val(),
            placa: $('#placa').val(),
            cor: $('#cor').val()

        };

        // atenção que esta estrutura em javascript precisa respeitar a mesma estrutura
        // do modelo criado no java.
        // os valores que estão sendo passado via JQUERY $('#xxx') precisam ter o mesmo
        // nome do id no input, div, textarea, etc

        var datastr = JSON.stringify(data);

        // JSON.stringify - método que transforma o modelo javascript em string

        if (data.id == '' || data.id == undefined) {
            this.dataBind(
                    'POST',
                    datastr,
                    '/api/veiculo',
                    this._salvaClickSuccess,
                    this._salvaClickError);
        } else {
            this.dataBind(
                    'PUT',
                    datastr,
                    '/api/veiculo',
                    this._alterarClickSuccess,
                    this._alterarClickError);
        }

    },
    _salvaClickSuccess: function (value) {
        $('#marca').val('');
        $('#modelo').val('');
        $('#placa').val('');
        $('#cor').val('');
        $('#tabela').html('');
        this._obterVeiculos();
        alert("Salvo com sucesso!");
    },
    _salvaClickError: function (value) {

        alert(value + "Erro ao salvar");

    },

    dataBind: function (type, data, url, success, error) {
        $.ajax({
            type: type,
            cache: false,
            data: data,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: url,
            success: $.createDelegate(this, success),
            error: $.createDelegate(this, error)
        });
    }
};

$(document).ready(function () {
    Index.Load();
});