package br.com.raphael.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphael.dslist.dto.GameMinDTO;
import br.com.raphael.dslist.entities.Game;
import br.com.raphael.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		/*
		 *  Transforma uma lista de games em uma lista de GameDTO;
		 *  stream(): faz operações com sequencias de dados;
		 *  map(): transforma objetos (usando a expressão lambda);
		 *  toList(): converte para lista novamente;
		 */
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
