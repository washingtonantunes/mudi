package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("home")
public class HomeController {
	
	static {
//		Pedido pedido1 = new Pedido();
//		pedido1.setNomeProduto("Xiaomi Redmi Note 8");
//		pedido1.setUrlImagem("https://m.media-amazon.com/images/I/51yUoUqC0-L._AC_SX522_.jpg");
//		pedido1.setUrlProduto("https://m.media-amazon.com/images/I/51yUoUqC0-L._AC_SX522_.jpg");
//		pedido1.setDescricao("descrição do produto");
//		pedido1.setStatus(StatusPedido.AGUARDANDO);
//		
//		pedidoRepository.save(pedido1);
//		
//		Pedido pedido2 = new Pedido();
//		pedido2.setNomeProduto("Echo Dot (4ª Geração): Smart Speaker com Alexa - Cor Preta");
//		pedido2.setUrlImagem("https://m.media-amazon.com/images/I/714Rq4k05UL._AC_SX425_.jpg");
//		pedido2.setUrlProduto("https://m.media-amazon.com/images/I/714Rq4k05UL._AC_SX425_.jpg");
//		pedido2.setDescricao("descrição do produto");
//		pedido2.setStatus(StatusPedido.APROVADO);
//		
//		pedidoRepository.save(pedido2);
//		
//		Pedido pedido3 = new Pedido();
//		pedido3.setNomeProduto("BLACK+DECKER Parafusadeira e Furadeira de 3/8 Pol. (10mm) a Bateria 12V Ion-Litio 1.5Ah 900 RPM com 13 Acessórios e Caixa Plástica LD12SP");
//		pedido3.setUrlImagem("https://m.media-amazon.com/images/I/51NPkQERPXL._AC_SY355_.jpg");
//		pedido3.setUrlProduto("https://m.media-amazon.com/images/I/51NPkQERPXL._AC_SY355_.jpg");
//		pedido3.setDescricao("descrição do produto");
//		pedido3.setStatus(StatusPedido.ENTREGUE);
//		
//		pedidoRepository.save(pedido3);
	}
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {
		
		Sort sort = Sort.by("dataDaEntrega").ascending();
		
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
