package com.onlinevn.service;

import com.onlinevn.entity.Asset;
import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Item;
import com.onlinevn.entity.Novel;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.FrameRepository;
import com.onlinevn.repository.ItemRepository;
import com.onlinevn.repository.NovelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FrameService {

    private final FrameRepository frameRepository;
    private final NovelRepository novelRepository;


    public FrameService(FrameRepository frameRepository, NovelRepository novelRepository) {
        this.frameRepository = frameRepository;
        this.novelRepository = novelRepository;
    }

    @Transactional
    public Frame createFrame(Frame frame) {
        return frameRepository.save(frame);
    }

    public List<Frame> readAll() {
        return frameRepository.findAll();
    }

    public List<Frame> readFramesByNovelId(Integer novelId) {
        List<Frame> frames = frameRepository.findByNovelId(novelId);
        if (frames.isEmpty()) throw new NotFoundException();
        return frames;
    }

    public long countByNovelId(Integer novelId) {
        return frameRepository.countByNovelId(novelId);
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
            Frame frame = frameRepository.getById(id);
            Novel novel = novelRepository.getByFirstFrame(id);
            if (novel != null) {
                if (frame.getNextFrame() != null) {
                    Frame nextFrame = frameRepository.getById(frame.getNextFrame());
                    nextFrame.setPrevFrame(null);
                    frameRepository.save(nextFrame);
                    novel.setFirstFrame(nextFrame.getId());
                } else {
                    novel.setFirstFrame(null);
                }
                novelRepository.save(novel);
            } else {
                if (frame.getNextFrame() == null) {
                    Frame prevFrame = frameRepository.getById(frame.getPrevFrame());
                    prevFrame.setNextFrame(null);
                    frameRepository.save(prevFrame);
                } else {
                    Frame nextFrame = frameRepository.getById(frame.getNextFrame());
                    Frame prevFrame = frameRepository.getById(frame.getPrevFrame());
                    nextFrame.setPrevFrame(frame.getPrevFrame());
                    prevFrame.setNextFrame(frame.getNextFrame());
                    frameRepository.save(prevFrame);
                    frameRepository.save(nextFrame);
                }
            }
            frameRepository.delete(frame);
        } else {
            throw new NotFoundException();
        }
    }

    @Transactional
    public Frame addItemToFrame(Frame frame, Integer itemId) {
        frame.getItems().add(itemId);
        return frameRepository.save(frame);
    }

    @Transactional
    public Frame deleteItemFromFrame(Frame frame, Integer itemId) {
        frame.getItems().remove(itemId);
        return frameRepository.save(frame);
    }
}
