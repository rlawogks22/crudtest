package com.example.crudtest.Service;

import com.example.crudtest.Entitiy.Board;
import com.example.crudtest.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> BoardList() {
        return boardRepository.findAll();
    }

    public Optional<Board> BoardOne(String uid) {
        return boardRepository.findById(Long.valueOf(uid));
    }

    public void ViewcntUpdate(String uid) {
        Optional<Board> boardOptional = boardRepository.findById(Long.valueOf(uid));
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            int currentViewCount = board.getVicwcnt(); // Get the current view count
            board.setVicwcnt(currentViewCount + 1); // Increase the view count by 1
            boardRepository.save(board);
        }
    }

    public void BoardAdd(Board board) {
        boardRepository.save(board);
    }
}