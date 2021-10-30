package com.onlinevn.service;

import com.onlinevn.entity.Asset;
import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Item;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.FrameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FrameService {

    private final FrameRepository frameRepository;

    public FrameService(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Transactional
    public Frame createFrame(Frame frame) {
        return frameRepository.findById(frame.getId())
                .orElse(frameRepository.save(frame));
    }

    public List<Frame> readAll() {
        return frameRepository.findAll();
    }

    public List<Frame> readFramesByNovelId(Integer novelId) {
        List<Frame> frames = frameRepository.findByNovelId(novelId);
        if (frames.isEmpty()) throw new NotFoundException();
        return frames;
    }

    public Frame readFrameById(Integer id) {
        return frameRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Frame updateFrame(Frame frame) {
        if (frameRepository.existsById(frame.getId())) {
            frameRepository.save(frame);
        } else {
            throw new NotFoundException();
        }
        return frame;
    }

    @Transactional
    public void delete(Integer id) {
        if (frameRepository.existsById(id)) {
            frameRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public Frame addItemToFrame(Frame frame, Item item) {
        frame.getItems().add(item);
        return frameRepository.save(frame);
    }

    @Transactional
    public Frame deleteItemFromFrame(Frame frame, Item item) {
        frame.getItems().remove(item);
        return frameRepository.save(frame);
    }
}
