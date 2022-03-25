import { useState, useRef, React } from 'react'
import './SectionDestino.css'
import api from '../../../api'

const FormularioDestino = () => {
    const nome= useRef()
    const descricao= useRef()
    const imagem= useRef()
    const preco= useRef()


    const [Nome, setNome] = useState("")
    const [Descricao, setDescricao] = useState("")
    const [Imagem, setImagem] = useState("")
    const [Preco, setPreco] = useState("")

    function enviarDados(event){
        event.preventDefault()
        api.post("/destino/adicionar",{
            nome: nome.current.value,
            descricao: descricao.current.value,
            imagem: imagem.current.value,
            preco: preco.current.value

            
        }).then((res)=>console.log(res.data)).catch((err)=>console.log(err))
    }


    return (
        <section className="d-flex justify-content-center">
            <div className="card col-sm-6 p-3">
                <div className="mb-3">
                    <h4>Cadastrar Destino</h4>
                </div>
                <div className="mb-2">
                    <form onSubmit={enviarDados}>
                        <div className="mb-2">
                            <label for="nome">Nome:</label>
                            <input type="text" required className="form-control" ref={nome}nome="nome" id="nome" placeholder="Nome Completo" value={Nome} onChange={e => setNome(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label for="destino">Destino</label>
                            <input type="text" required className="form-control" ref={descricao}nome="Destino" id="descricao" placeholder="Ex: Escreva seu destino" value={Descricao} onChange={e => setDescricao(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label for="url">Url Imagem</label>
                            <input type="text" required className="form-control" ref={imagem} nome="url" id="imagem" placeholder="Url Imagem" value={Imagem} onChange={e => setImagem(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <label for="preco">Preço</label>
                            <input type="text" required className="form-control" ref={preco}  nome="preco" id="preco" placeholder="R$ 1.800,00" value={Preco} onChange={e => setPreco(e.target.value)} />
                        </div>
                        <div className="mb-2">
                            <button className="btn btn-secondary btn-lg btn-block" onChange={e => alert(e.target.value)}>Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    );
}

export default FormularioDestino